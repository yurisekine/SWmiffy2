/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.KlDAO;

/**
 *
 * @author kaho
 */
public class DeleteKlLogic {
    public void execute() {
        KlDAO dao = new KlDAO();
        dao.delete();
    }
}
