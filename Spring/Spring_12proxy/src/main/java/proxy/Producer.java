package proxy;

/**
 * @author:profiteur
 * @create 2020-02-13 17:18
 * @description 生产者
 **/
public class Producer implements IProducer{
    /**
     * 销售
     * @param money
     */
    public void saleProduct(float money){
        System.out.println("销售产品，并拿到钱：" + money);
    }

    /**
     * 售后
     * @param money
     */
    public void afterService(float money){
        System.out.println("提供售后，并拿到钱：" + money);
    }
}
