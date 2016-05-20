package org.popkit.appkit.gist;

/**
 * Created by Aborn Jiang
 * Mail aborn.jiang@gmail.com
 * 2016-05-20:08:14
 */
public class FetchFile {
    private String pkgName;
    private String fileName;
    private long lastCommit;
    private String lastCommitFormmatter;

    public String getPkgName() {
        return pkgName;
    }

    public void setPkgName(String pkgName) {
        this.pkgName = pkgName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getLastCommit() {
        return lastCommit;
    }

    public void setLastCommit(long lastCommit) {
        this.lastCommit = lastCommit;
    }

    public String getLastCommitFormmatter() {
        return lastCommitFormmatter;
    }

    public void setLastCommitFormmatter(String lastCommitFormmatter) {
        this.lastCommitFormmatter = lastCommitFormmatter;
    }
}
