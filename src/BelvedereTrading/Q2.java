package BelvedereTrading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Arrays;

public class Q2
        // You are working for a manufacturing company, and are trying to make your product as cheaply as possible.
        // Let's say you're making teddy bears. You can potentially buy painted glass eyeballs, tiny shirts, fake bear cloth,
        // and sewing thread, and put them all together in your factory to produce the teddy bear. But to save money,
        // maybe you can build the painted glass eyeballs yourself by buying glass and paint. And so on and so forth.
        // You could even build your own paint if it's cheaper than purchasing paint directly!
        // Your goal is to figure out the cheapest way to make your product.
        // There are no costs associated with combining inputs into a product. The first part of the input will be the product
        // you are trying to obtain (the "target product"). The second part will be data representing how to build and/or purchase
        // various products. Your code should output the cheapest way to obtain the target product (either via building it yourself
        // or purchasing it).

        // input:
        // A target product
        //For each Product:
        //The name of the product
        //The price to purchase the product directly
        //The number of products required as inputs to build the product
        //A list of products required as inputs to build the product

        // output:
        // A number, formatted with two decimal places, that is the cheapest possible price to manufacture the target product

        // notes:
        // The target product will always be possible to build and/or purchase
        //There are no "cycles" of inputs. For example, it would never be the case that product A is an input to product B, but product B is also an input to product A
        //Some products are "raw inputs", and are unable to be produced. They must be purchased. They have an empty list of input products (in the above example, bear, yarn, sewing thread, and tiny shirt are all "raw inputs")
        //Since the output is simply the cheapest price to produce the target product, it does not matter if there is a tie between the price to purchase the target product and the price to produce it
        //It is possible to for a product to be an input to multiple other products
        //If a product is in input_products, it is guaranteed to be listed as a product

        // input output example:
        // car
        //car,30000,5,seat;steering wheel;carpet;windshield;radio
        //radio,200,0,
        //steering wheel,null,3,leather;plastic;foam
        //seat,null,3,leather;foam;plastic
        //plastic,1300,0,
        //foam,7000,0,
        //leather,4000,0,
        //carpet,1000,1,plastic
        //windshield,5000,1,glass
        //glass,2000,1,sand
        //sand,0,0,

        // 25800.00

        // office chair
        //wheels,3.5,2,plastic;metal
        //cushioned seat,7.5,3,screws;padding;leather
        //screws,1.5,1,metal
        //arm rests,5,3,padding;plastic;leather
        //lumbar support,15,4,plastic;padding;leather;screws
        //plastic,2,0,
        //padding,3,0,
        //leather,4,0,
        //metal,1,0,
        //office chair,26.25,5,wheels;cushioned seat;screws;arm rests;lumbar support

        // 26.25

        // sandwich
        //mayonnaise,1,0,
        //sand,0,0,
        //bread,3,3,yeast;water;flour
        //flour,1,0,
        //water,1,0,
        //yeast,1,0,
        //sandwich,10,6,mayonnaise;sand;bread;mozzarella;bacon;salt
        //bacon,3,1,pig
        //pig,1000,0,
        //salt,1,2,sea salt;iodine
        //iodine,40,0,
        //sea salt,.5,0,
        //mozzarella,3,0,

        // 10.00

        // teddy bear
        //painted glass eyeball,10.5,2,glass;paint
        //glass,5,0,
        //paint,4,0,
        //teddy bear,null,4,painted glass eyeball;tiny shirt;faux bear fur fabric;sewing thread
        //faux bear fur fabric,15,2,bear;yarn
        //bear,100,0,
        //yarn,2,0,
        //sewing thread,13,0,
        //tiny shirt,24,0,

        // 61.00
{
    private static DecimalFormat formatter = new DecimalFormat("0.00");

    public static class Product
    {
        public Product(String productName, Double priceToPurchase, HashSet<String> inputProducts)
        {
            ProductName = productName;
            PriceToPurchase = priceToPurchase;
            InputProducts = inputProducts;
        }

        public String ProductName;
        public Double PriceToPurchase;
        public HashSet<String> InputProducts;

        @Override
        public boolean equals(Object obj)
        {
            if (this == obj)
                return true;

            if(obj == null || obj.getClass()!= this.getClass())
                return false;

            Product product = (Product) obj;

            return (product.ProductName == this.ProductName);
        }

        @Override
        public int hashCode()
        {
            return this.ProductName.hashCode();
        }
    }

    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException
    {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        String targetProductName = "";
        HashSet<Product> allProducts = new HashSet<Product>();
        Boolean isFirstLine = true;
        while ((line = in.readLine()) != null) {
            if (isFirstLine)
            {
                targetProductName = line;
                isFirstLine = false;
                continue;
            }

            String[] lineSplit = line.split(",");
            allProducts.add(new Product(lineSplit[0], lineSplit[1].equals("null") ? null : Double.parseDouble(lineSplit[1]),
                    lineSplit.length == 3 ? new HashSet<String>() : new HashSet<String>(Arrays.asList(lineSplit[3].split(";")))));
        }
        System.out.println(formatter.format(mySolution(targetProductName, allProducts)));
    }

    static Double mySolution(String targetProductName, HashSet<Product> allProducts)
    {
        // ADD IMPLEMENTATION HERE
        return 1.0;
    }
}





