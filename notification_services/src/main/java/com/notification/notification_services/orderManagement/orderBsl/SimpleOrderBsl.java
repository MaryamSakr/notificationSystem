package com.notification.notification_services.orderManagement.orderBsl;
import com.notification.notification_services.ProductManagement.ProductModules.Product;
import com.notification.notification_services.ShippingManagment.ShippingModules.shipping;
import com.notification.notification_services.customerMangment.customerModeles.Customer;
import com.notification.notification_services.inMemoeryCustomer;
import com.notification.notification_services.inMemory;
import com.notification.notification_services.inMemoryOrder;
import com.notification.notification_services.orderManagement.orderModules.Order;
import com.notification.notification_services.orderManagement.orderModules.SimpleOrder;
import org.springframework.stereotype.Service;
<<<<<<< HEAD
@Service
public class SimpleOrderBsl extends OrderBsl{
    private SimpleOrder simpleOrder ;
    boolean flag = false;
    public SimpleOrderBsl() {
        this.simpleOrder=new SimpleOrder();
    }
    public SimpleOrderBsl(SimpleOrder simpleOrder){
        super();
        this.simpleOrder = simpleOrder;
    }
=======
import com.notification.notification_services.inMemory;

@Service
public class SimpleOrderBsl extends OrderBsl{

    protected SimpleOrder simpleOrder;
>>>>>>> e2e9aec172082c7213142bcd70b6677aebdae11f
    @Override
    public double calcTotal() {
        shipping ship = new shipping();
        double price =0;
<<<<<<< HEAD
        for (Customer customer : inMemoeryCustomer.customers) {
            if(simpleOrder.getCustomerName().equals(customer.getUserName())){
                this.flag =true;
                ship.setLocation(customer.getLocation());
                price = ship.calcFees();
                customer.setBalance(customer.getBalance()-price);
            }
        }
        if(!this.flag){
            return 0;
        }
        simpleOrder.setShipFees(price);
        for (Product product:simpleOrder.getProducts()) {
            for (Product pro : inMemory.products ){
                if(product.getName().equals(pro.getName())){
=======
        for (Product pro: inMemory.products) {
            for (String name : simpleOrder.getProducts()) {
                if (name .equals(pro.getName())) {
>>>>>>> e2e9aec172082c7213142bcd70b6677aebdae11f
                    price = price + pro.getPrice();
                }
            }
        }
        return price;
    }
<<<<<<< HEAD
    @Override
    public String addOrder(Order o){
        simpleOrder = (SimpleOrder) o;
        simpleOrder.setTotalPrice(calcTotal());
        if(!this.flag){
            return simpleOrder.getCustomerName()+" doesn't exist";
        }
        simpleOrder.setId(inMemoryOrder.orders.get(inMemoryOrder.orders.size()-1).getId() +1 );
        System.out.println(simpleOrder.getId());
        inMemoryOrder.orders.add(o);
=======

    @Override
    public String addOrder(Order o) {
        for(Order order:this.orders) {
            if(o.getId()==order.getId()){
                return "This order already exist";
            }
        }
        o.setTotalPrice(calcTotal(o));
        orders.add(o);
>>>>>>> e2e9aec172082c7213142bcd70b6677aebdae11f
        return "Added successfully";
    }
}
