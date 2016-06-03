/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author g14931mh
 */

import java.util.List;

import dao.MutterDAO;

public class GetMutterListLogic {
    
    public List<Mutter> execute(){
        MutterDAO dao = new MutterDAO();
        List<Mutter> mutterList = dao.findAll();
        return mutterList;
    }
}
