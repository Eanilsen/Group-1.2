/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit.ejb.filetransfer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import slit.entities.UploadedFile;

/**
 * This is a simple file transfer service. Files can be uploaded and added to
 * the database, and retrieved from the database and downloaded. There is no
 * provision for updating or overwriting uploaded files. Every upload is treated
 * as a new file. The files must be small enough to be held in memory.
 *
 * @author evenal
 */
@Stateless
public class FileTransferBean implements FileTransferRemote
{

    @PersistenceContext
    EntityManager em;

    /**
     * The client calls upload() to upload file :-)
     *
     * @param file a FileTransfer object which contains the file to upload
     */
    @Override
    public void upload(FileTransfer file) {
        // Create an UploadedFile entity for storing the file in the database
        UploadedFile upload = new UploadedFile(file);
        System.out.println("Storing file in database");
        // add the entity to the database
        em.persist(upload);
        // and we're done
        System.out.println("File uploaded and stored!");
    }

    /**
     * The client calls download() to download a file
     *
     * @param fileId the primary key of the file to download
     * @return
     */
    public FileTransfer download(Long fileId) {
        // get the entity from the database
        UploadedFile uf = em.find(UploadedFile.class, fileId);
        if (null == uf)
            // if invalid key -> no file -> return null
            return null;
        else
            // create a filetransfer object and return it
            return new FileTransfer(uf.getId(), uf.getPurpose(),
                                    uf.getFilename(), uf.getContent());
    }
}
