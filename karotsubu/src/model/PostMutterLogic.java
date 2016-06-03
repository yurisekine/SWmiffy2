/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.MutterDAO;

/**
 *
 * @author kaho
 */
public class PostMutterLogic {
    public void execute(Mutter mutter){
        MutterDAO dao = new MutterDAO();
        dao.create(mutter);
    }
}