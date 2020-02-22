package proxy;

/**
 * @author:profiteur
 * @create 2020-02-13 17:28
 * @description 生产者接口
 **/
public interface IProducer {
    /**
     * 销售
     * @param money
     */
    public void saleProduct(float money);

    /**
     * 售后
     * @param money
     */
    public void afterService(float money);
}
