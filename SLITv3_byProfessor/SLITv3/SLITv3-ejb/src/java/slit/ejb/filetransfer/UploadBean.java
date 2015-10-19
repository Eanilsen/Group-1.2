/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit.ejb.filetransfer;

import javax.ejb.Stateless;



/**
 *
 * @author evenal
 */
@Stateless
public class UploadBean implements UploadBeanRemote
{

    @Override
    public void upload(FileTransfer file) {
        System.out.println("Uploaded file:");
        System.out.println("Id : " + file.getId());
        System.out.println("Filename : " + file.getFilename());
        System.out.println("Contents : ");
        System.out.println(file.getFileContent());
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
