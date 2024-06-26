package Wayfair;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CouponQuestionV1V2 {

    static class Coupon {
        String couponName;
        Date dateModified;

        Coupon(String couponName, Date dateModified) {
            this.couponName = couponName;
            this.dateModified = dateModified;
        }

        @Override
        public String toString() {
            return "Coupon{" +
                    "couponName='" + couponName + '\'' +
                    ", dateModified=" + dateModified +
                    '}';
        }
    }

    private static final Map<String, List<Coupon>> couponsToCategoryMapping = new HashMap<String, List<Coupon>>();
    private static final Map<String, String> categoryToParentCategoryMapping = new HashMap<String, String>();

    private static final String dateFormat = "yyyy-MM-dd";

    private static String findParent(String category) {

        String parentCategory = categoryToParentCategoryMapping.get(category);
        if (parentCategory.equals("Null")) {
            return parentCategory;
        } else if (couponsToCategoryMapping.containsKey(parentCategory)) {
            return parentCategory;
        }
        categoryToParentCategoryMapping.put(category, findParent(parentCategory));
        return categoryToParentCategoryMapping.get(category);
    }

    private static String getCouponForCategory(String category) {

        if (couponsToCategoryMapping.containsKey(category)) {
            return couponsToCategoryMapping.get(category).get(0).couponName;
        }

        String categoryWhichHasCoupon = findParent(category);
        if (categoryWhichHasCoupon.equals("Null")) {
            return categoryWhichHasCoupon;
        }
        return couponsToCategoryMapping.get(categoryWhichHasCoupon).get(0).couponName;
    }

    public static void main(String[] args) throws ParseException {

        List<String[]> coupons = List.of(
                new String[]{"CategoryName:Comforter Sets", "CouponName:Comforters Sale", "DateModified:2022-01-01"},
                new String[]{"CategoryName:Comforter Sets", "CouponName:Cozy Comforter Coupon", "DateModified:2018-01-01"},
                new String[]{"CategoryName:Bedding", "CouponName:Best Bedding Bargains", "DateModified:2019-01-01"},
                new String[]{"CategoryName:Bedding", "CouponName:Savings on Bedding", "DateModified:2022-01-01"},
                new String[]{"CategoryName:Bed & Bath", "CouponName:Low price for Bed & Bath", "DateModified:2018-01-01"},
                new String[]{"CategoryName:Bed & Bath", "CouponName:Bed & Bath extravaganza", "DateModified:2019-01-01"}
        );


        List<String[]> categories = List.of(
                new String[]{"CategoryName:Comforter Sets", "CategoryParentName:Bedding"},
                new String[]{"CategoryName:Bedding", "CategoryParentName:Bed & Bath"},
                new String[]{"CategoryName:Bed & Bath", "CategoryParentName:None"},
                new String[]{"CategoryName:Soap Dispensers", "CategoryParentName:Bathroom Accessories"},
                new String[]{"CategoryName:Bathroom Accessories", "CategoryParentName:Bed & Bath"},
                new String[]{"CategoryName:Toy Organizers", "CategoryParentName:Baby And Kids"},
                new String[]{"CategoryName:Baby And Kids", "CategoryParentName:Null"}
        );
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        for (String[] coupon : coupons) {

            if (couponsToCategoryMapping.get(coupon[0].split(":")[1]) == null) {
                couponsToCategoryMapping.put(coupon[0].split(":")[1], new ArrayList<>());
            }
            couponsToCategoryMapping.get(coupon[0].split(":")[1]).add(new Coupon(coupon[1].split(":")[1], simpleDateFormat.parse(coupon[2].split(":")[1])));
        }

        for (Map.Entry<String, List<Coupon>> couponsEntry : couponsToCategoryMapping.entrySet()) {
            Collections.sort(couponsEntry.getValue(), (a, b) ->
                    b.dateModified.compareTo(a.dateModified)
            );
        }

        for (String[] category : categories) {
            categoryToParentCategoryMapping.put(category[0].split(":")[1], category[1].split(":")[1]);
        }


        for(Map.Entry<String, List<Coupon>> mapEntry : couponsToCategoryMapping.entrySet()){
            System.out.println(mapEntry.getKey()+" "+mapEntry.getValue());
        }
        System.out.print("Comforter Sets => ");
        System.out.println(getCouponForCategory("Comforter Sets"));
        System.out.print(("Bedding => "));
        System.out.println(getCouponForCategory("Bedding"));
        System.out.print(("Bathroom Accessories => "));
        System.out.println(getCouponForCategory("Bathroom Accessories"));
        System.out.print(("Soap Dispensers => "));
        System.out.println(getCouponForCategory("Soap Dispensers"));
        System.out.print(("Toy Organizers => "));
        System.out.println(getCouponForCategory("Toy Organizers"));
    }
}
