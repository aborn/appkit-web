package org.popkit.appkit.common.utils;

import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author aborn.jiang
 * @email aborn.jiang AT foxmail.com
 * @date 04-15-2015
 * @time 2:02 PM
 */
public class FileUtils {

    /**
     * 删除文件夹下所有文件
     * 如果该文件夹不存在，返回true
     * @param directory
     * @return
     */
    public static boolean deleteAllFiles(String directory) {
        File file = new File(directory);
        if (file.isDirectory() && file.exists()) {
            String[] files = file.list();
            boolean flag = true;
            for (String item : files) {
                File tmpFile = new File(directory + File.separator + item);
                if (tmpFile.exists()) {
                    flag = flag && tmpFile.delete();
                }
            }

            return flag;
        } else {
            return true;
        }
    }

    public static boolean createDirectory(String directory) {
        File file = new File(directory);
        //如果文件夹不存在则创建
        if  (!file .exists()  && !file .isDirectory()) {
            file.mkdirs();
            return true;
        } else {
            return true;
        }
    }

    /**
     * 根据文件名创建其所在路径的目录
     * @param path
     * @return
     */
    public static boolean createDirectoryBaseFileName(String path) {
        if (StringUtils.isEmpty(path) || (!path.contains(File.separator))) {
            return false;
        }

        String filePath = path.substring(0, path.lastIndexOf(File.separator));
        return createDirectory(filePath);
    }

    /**
     * 从图片url下载图片到本地
     * @param remoteFilePath  图片远程的url路径
     * @param localFilePath 本地图片保存的路径
     * @return
     */
    public static boolean downloadFile(String remoteFilePath, String localFilePath) {
        URL urlfile = null;
        HttpURLConnection httpUrl = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        File f = new File(localFilePath);

        if (!createDirectoryBaseFileName(localFilePath)) {
            return false;
        }

        try {
            if (f.exists()) {  // 删除老的图片，更新下图片
                f.delete();
            }

            urlfile = new URL(remoteFilePath);
            httpUrl = (HttpURLConnection)urlfile.openConnection();
            httpUrl.connect();
            bis = new BufferedInputStream(httpUrl.getInputStream());
            bos = new BufferedOutputStream(new FileOutputStream(f));
            int len = 2048;
            byte[] b = new byte[len];
            while ((len = bis.read(b)) != -1) {
                bos.write(b, 0, len);
            }
            bos.flush();
            bis.close();
            httpUrl.disconnect();
            return f.exists();
        } catch (Exception e) {
            return false;
        } finally {
            try {
                bis.close();
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String humanReadableByteCount(long bytes, boolean si) {
        int unit = si ? 1000 : 1024;
        if (bytes < unit) return bytes + " B";
        int exp = (int) (Math.log(bytes) / Math.log(unit));
        String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp-1) + (si ? "" : "i");
        return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
    }

    public static void main(String[] args) {
        File f = new File("/abc/fas/a.txt");
        String absolutePath = f.getAbsolutePath();
        System.out.println("getPath:" + f.getPath());

        String filePath = absolutePath.
                substring(0, absolutePath.lastIndexOf(File.separator));

        System.out.println("pathonly:" + filePath);
    }
}
