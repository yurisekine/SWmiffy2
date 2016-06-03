/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.MutterDAO;

/**
 *
 * @author g14931mh
 */
public class PostMutterLogic {
    public void execute(Mutter mutter){
        MutterDAO dao = new MutterDAO();
        dao.create(mutter);
    }
}
