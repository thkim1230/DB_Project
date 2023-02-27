package com.kh.dbTest.dao;
import com.kh.dbTest.util.Common;
import com.kh.dbTest.vo.SalesVO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class SalesDAO {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);

        public List<SalesVO> dailySalSel() {
                List<SalesVO> list = new ArrayList<>();
                try {
                        conn = Common.getConnection();
                        stmt = conn.createStatement();
                        String sql = "SELECT SUM(SALES), P_DATE FROM SALES_STATEMENT GROUP BY P_DATE ORDER BY P_DATE";
                        rs = stmt.executeQuery(sql);

                        while (rs.next()) {
                                Date pDate = rs.getDate("P_DATE");
                                int sumSales = rs.getInt("SUM(SALES)");
                                SalesVO vo = new SalesVO();
                                vo.setP_Date(pDate);
                                vo.setSales(sumSales);
                                list.add(vo);
                        }
                        Common.close(rs);
                        Common.close(stmt);
                        Common.close(conn);
                } catch (Exception e) {
                        e.printStackTrace();
                }
                return list;
        }

        public void dailySalSelPrint(List<SalesVO> list) {
                for (SalesVO e : list) {
                        System.out.println("일 : " + e.getP_Date());
                        System.out.println("매출 : " + e.getSales());
                        System.out.println("--------------------------------------");
                }
        }


        public List<SalesVO> monthlySalSel() {
                List<SalesVO> list = new ArrayList<>();
                try {
                        conn = Common.getConnection();
                        stmt = conn.createStatement();
                        String sql = "SELECT SUM(SALES), TO_CHAR(P_DATE, 'YYYY/MM') FROM SALES_STATEMENT GROUP BY TO_CHAR(P_DATE, 'YYYY/MM')";
                        rs = stmt.executeQuery(sql);

                        while (rs.next()) {
                                Date pDate = rs.getDate("TO_CHAR(P_DATE,'YYYY/MM')");
                                int sumSales = rs.getInt("SUM(SALES)");
                                SalesVO vo = new SalesVO();
                                vo.setP_Date(pDate);
                                vo.setSales(sumSales);
                                list.add(vo);
                        }
                        Common.close(rs);
                        Common.close(stmt);
                        Common.close(conn);
                } catch (Exception e) {
                        e.printStackTrace();
                }
                return list;
        }

        public void monthlySalSelPrint(List<SalesVO> list) {
                for (SalesVO e : list) {
                        System.out.println("월 : " + e.getP_Date());
                        System.out.println("매출 : " + e.getSales());
                        System.out.println("--------------------------------------");
                }
        }

        public List<SalesVO> annualSalSel() {
                List<SalesVO> list = new ArrayList<>();
                try {
                        conn = Common.getConnection();
                        stmt = conn.createStatement();
                        String sql = "SELECT SUM(SALES), TO_CHAR(P_DATE, 'YYYY') FROM SALES_STATEMENT GROUP BY TO_CHAR(P_DATE, 'YYYY')";
                        rs = stmt.executeQuery(sql);

                        while (rs.next()) {
                                Date pDate = rs.getDate("TO_CHAR(P_DATE,'YYYY')");
                                int sumSales = rs.getInt("SUM(SALES)");
                                SalesVO vo = new SalesVO();
                                vo.setP_Date(pDate);
                                vo.setSales(sumSales);
                                list.add(vo);
                        }
                        Common.close(rs);
                        Common.close(stmt);
                        Common.close(conn);
                } catch (Exception e) {
                        e.printStackTrace();
                }
                return list;
        }

        public void annualSalSelPrint(List<SalesVO> list) {
                for (SalesVO e : list) {
                        System.out.println("년 : " + e.getP_Date());
                        System.out.println("매출 : " + e.getSales());
                        System.out.println("--------------------------------------");
                }
        }



}
