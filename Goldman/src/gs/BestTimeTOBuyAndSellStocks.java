package gs;

public class BestTimeTOBuyAndSellStocks {
    public int maxProfit(int[] prices) {
        int result=0;
        int min=prices[0];
        int profit=0;
        for(int i=0;i<prices.length;i++){
            min=Math.min(prices[i],min);
            profit=prices[i]-min;
            result=Math.max(result,profit);
        }
        return result;
    }
    public static void main(String[] args){
        int[] arr = {7,1,5,3,6,4};
        System.out.println(new BestTimeTOBuyAndSellStocks().maxProfit(arr));
    }
}
