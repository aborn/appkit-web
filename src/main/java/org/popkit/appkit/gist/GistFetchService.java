package org.popkit.appkit.gist;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PullCommand;
import org.eclipse.jgit.api.PullResult;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.popkit.appkit.common.log.AppkitLogger;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Aborn Jiang
 * Mail aborn.jiang@gmail.com
 * 2016-05-20:07:01
 */
@Service
public class GistFetchService {
    private static final String LOCAL_PATH = "gist";
    private static ConcurrentHashMap<String, FetchEvent> fetchEventMap = new ConcurrentHashMap<String, FetchEvent>();

    public static String getGistFetchRootPath() {
        return System.getProperty("user.home") + "/" + LOCAL_PATH + "/";
    }

    public void fetch(final String pkgName, final String remote_url) {
        File file = new File(GistFetchService.getGistFetchRootPath() + pkgName);
        File fileDotGit = new File(GistFetchService.getGistFetchRootPath() + pkgName + "/.git");
        if (file.exists() && file.isDirectory() && fileDotGit.exists()) {
            if (fetchEventMap.containsKey(pkgName)) {
                AppkitLogger.info("already execute update, directory return!");
                return;
            }
            fetchEventMap.put(pkgName, new FetchEvent(new Date()));

            new Thread(new Runnable() {
                @Override
                public void run() {
                    AppkitLogger.info("update package now, pkgName:" + pkgName);
                    update(pkgName);
                    fetchEventMap.remove(pkgName);
                    AppkitLogger.info("finished package now, pkgName:" + pkgName);
                }
            }).start();

        } else {
            if (fetchEventMap.containsKey(pkgName)) {
                return;
            }
            fetchEventMap.put(pkgName, new FetchEvent(new Date()));

            new Thread(new Runnable() {
                @Override
                public void run() {
                    AppkitLogger.info("fetch package now, pkgName:" + pkgName);
                    create(pkgName, remote_url);
                    AppkitLogger.info("finished fetch package now, pkgName:" + pkgName);
                }
            }).start();
        }
    }

    public static long getLastCommiterTime(String pkgName) {
        try {
            String workingPath = getGistFetchRootPath() + pkgName;
            Repository repository = FileRepositoryBuilder.create(new File(workingPath + "/.git"));
            RevWalk revWalk = new RevWalk( repository );
            revWalk.markStart( revWalk.parseCommit(repository.resolve(Constants.HEAD)));
            // revWalk.sort(RevSort.COMMIT_TIME_DESC );
            // revWalk.sort(RevSort.REVERSE, false);
            RevCommit commit = revWalk.next();
            revWalk.dispose();
            return commit.getCommitterIdent().getWhen().getTime();
        } catch (Exception e) {
            AppkitLogger.warn("exception in getLastCommiterTime", e);
        }
        return 0;
    }

    private void update(String pkgName) {
        try {
            String localPath = getGistFetchRootPath() + pkgName;
            Repository repository = FileRepositoryBuilder.create(new File(localPath + "/.git"));
            //System.out.println("Starting fetch");

            Git git = new Git(repository);
            PullCommand pullCommand = git.pull();
            PullResult result = pullCommand.call();

            // http://stackoverflow.com/questions/13399990/usage-of-pull-command-in-jgit
            //FetchResult fetchResult = result.getFetchResult();
            //MergeResult mergeResult = result.getMergeResult();
            //mergeResult.getMergeStatus();  // this should be interesting

            //FetchResult result = git.fetch().setCheckFetchedObjects(true).call();
            //System.out.println("Messages: " + result.getMessages());
        } catch (Exception e) {
            AppkitLogger.info("exception in update(" + pkgName + ")", e);
        }
    }

    private void create(String pkgName, String remote_url) {
        // prepare a new folder for the cloned repository
        String localPathDir = getGistFetchRootPath() + pkgName;
        try {
            File localPath = File.createTempFile(localPathDir, "");
            localPath.delete();
        } catch (Exception e) {

        }

        // then clone
        try {
            Git result = Git.cloneRepository()
                    .setURI(remote_url)
                    .setDirectory(new File(localPathDir))
                    .call();
            // Note: the call() returns an opened repository already which needs to be closed to avoid file handle leaks!
            result.close();
        } catch (Exception e) {
            AppkitLogger.info("exception in create(" + pkgName + ")", e);
        } finally {
            //
        }
    }
}
