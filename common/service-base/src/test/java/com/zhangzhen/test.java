package com.zhangzhen;

public class test {
    //@Test
    public void testAccount() throws Exception {
        /*Connection conn = null;
        PreparedStatement ps = null;
        ResultSet result = null;
        try {
            //查询A账户余额有无够10000
            String sql = "select * from account where name = ? and balance >= ?";
            conn = DBUtils.getConnection();
            //将事务设置为手动提交 conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, "A");
            ps.setInt(2, 10000);
            result = ps.executeQuery();
            if (!result.next()) {
                throw new RuntimeException("您的余额不足");
            }
            //扣除A账户10000
            sql = "update account set balance = balance - ? where name = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, 10000);
            ps.setString(2, "A");
            ps.executeUpdate();
            //模拟中途断电异常
            System.out.println(1 / 0);
            // B账户增加10000
            sql = "update account set balance = balance + ? where name = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, 10000);
            ps.setString(2, "B");
            ps.executeUpdate();
            conn.commit();
            //提交（要整个事务都完成才能提交，因为提交之后就不能改变了）
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
            "6666".equals(22);
        }
        DBUtils.close(conn, ps, result);*/
    }

    public static void main(String[] args) throws InterruptedException {
        /*Object o = new Object();
        o.wait();*/
    }

  
}
