/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.MutterDAO;
import java.util.List;

/**
 *
 * @author g14944sy
 */
public class GetMutterListLogic {
    public List<Mutter> execute() {
        MutterDAO dao = new MutterDAO();
        List<Mutter> mutterList = dao.findAll();
        return mutterList;
    }
}
