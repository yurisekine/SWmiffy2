/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.KlDAO;
import java.util.List;

/**
 *
 * @author kaho
 */
public class GetKlListLogic {
    public List<Kl> execute(User user) {
        KlDAO dao = new KlDAO();
        List<Kl> klList = dao.findAll(user);
        return klList;
    }
}
