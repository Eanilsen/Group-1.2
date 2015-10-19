/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit.client.student;

import java.util.List;
import javax.swing.AbstractListModel;
import slit.ejb.filetransfer.Resource;

/**
 * This is the model behind the resource list component
 *
 * @author even
 */
public class ResourceListModel extends AbstractListModel
{

    List<Resource> data;

    public ResourceListModel(List<Resource> data) {
        System.out.println("Create ResListModel from " + data);
        System.out.println("contains " + data.size() + " items");
        this.data = data;
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Object getElementAt(int index) {
        Resource r = data.get(index);
        return r.getDescription() + "\n" + r.getFileName();
    }

    public long getFileId(int index) {
        Resource r = data.get(index);
        return null == r ? null : r.getFileId();
    }
}
