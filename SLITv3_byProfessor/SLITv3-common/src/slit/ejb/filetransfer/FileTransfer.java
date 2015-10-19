package slit.ejb.filetransfer;

import java.io.Serializable;

/**
 *
 * @author evenal
 */
public class FileTransfer implements Serializable
{

    public static final long SerialVersionUID = 1;

    private long id;
    private String purpose;
    private String filename;
    private String mimeType;
    private byte[] fileContent;

    public FileTransfer(long id, String purpose,
                        String filename, byte[] fileContent) {
        this.id = id;
        this.purpose = purpose;
        this.filename = filename;
        this.mimeType = mimeType;
        this.fileContent = fileContent;
    }

    public long getId() {
        return id;
    }

    public String getPurpose() {
        return purpose;
    }

    public String getFilename() {
        return filename;
    }

    public int getFileSize() {
        return fileContent.length;
    }

    public byte[] getFileContent() {
        return fileContent;
    }
}
