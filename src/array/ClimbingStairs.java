package array;

/**
 * 70. 爬楼梯  easy
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 *
 * @author ilovejava1314
 * @date 2019/11/10 16:02
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n < 3)
            return n;
        int f1 = 1,f2 = 2,f3 = 3;
        while (n > 2) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
            n--;
        }
        return f3;
    }
}
