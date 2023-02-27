package com.kh.dbTest;
import com.kh.dbTest.dao.SalesDAO;
import com.kh.dbTest.vo.SalesVO;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SalesDAO dao = new SalesDAO();
        while (true) {
            System.out.println("================== [Sales Table Command] ==================");
            System.out.println("                     메뉴를 선택 하세요");
            System.out.print("[1] SELECT, [2] INSERT, [3] UPDATE, [4] EXIT : ");
            int sel = sc.nextInt();

            switch (sel) {
                case 1 :
                    System.out.println("원하시는 조회를 선택 하세요");
                    System.out.println("[1] 일별 매출 조회, [2] 일별 주문내역 조회, [3] 월별 매출 조회, [4] 월별 주문내역 조회, [5] 년도별 매출 조회 [6] 년도별 주문내역 조회: ");
                    int salSel = sc.nextInt();
                    switch (salSel) {
                        case 1 :
                            List<SalesVO> list1= dao.dailySalSel();
                            dao.dailySalSelPrint(list1);
                            break;
                        case 2 :
                        case 3 :
                            List<SalesVO> list2 = dao.monthlySalSel();
                            dao.monthlySalSelPrint(list2);
                            break;
                        case 4 :
                        case 5 :
                            List<SalesVO> list3 = dao.annualSalSel();
                            dao.annualSalSelPrint(list3);
                            break;
                        case 6 :
                    }
                    break;
                case 2 :
                    break;
                case 3 :
                    break;
                case 4 :
                    System.out.println("메뉴를 종료 합니다.");
                    return;
            }
        }
    }
}

