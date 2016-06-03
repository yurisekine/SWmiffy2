package shopping;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author g14956wr
 */
import java.util.List;

import model.Mutter;
import dao.MutterDAO;

public class SelectMutterSample {

    public static void main(String[] args) {

        //employeeテーブルの全レコードを取得
        MutterDAO mutDAO = new MutterDAO();
        List<Mutter> mutList = mutDAO.findAll();

        //取得したレコードの内容を出力
        for (Mutter mut : mutList) {
            System.out.println("ID：" + mut.getId());
            System.out.println("名前：" + mut.getUserName());
            System.out.println("年齢：" + mut.getText() + "\n");
        }
    }
}
