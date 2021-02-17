# Description
Companies that sell their products on a worldwide e-commerce site analyze the customer review for their products in real time, as they flag a product rating or review with a “star” (like). The website is creating a category called “Top Stars” that will only display products  of sellers whose average percentage of stars per product is above or at a certain threshold. Given the number of starred reviews and total reviews for a catalog of products, as well as the threshold percentage, what is the minimum number of additional starred reviews the company needs to become a “top star” seller?

For example, let’s say there are 3 products (n=3) where product ratings are [4,4] [1,2] [3,6] and the percentage ratingsThreshold = 77%. The first number on each rating is the number of starred reviews followed by the total number of reviews. Here is how we can reach the threshold in three steps:

```
Initial   - [ [4,4] [1,2] [3,6] ] => [ [4/4] + [1/2] + [3/6] ] / 3  => 66%
Step 1 - [ [4,4] [2,3] [3,6] ] => 72.22%
Step 2 - [ [4,4] [3,4] [3,6] ] => 75%
Step 3 - [ [4,4] [3,4] [4,7] ] => 77.38%
```

At this point, the threshold has been met and so the answer is 3.

A sample signature for a Java method would be:

```
public static int starReviews(List<List<Integer>> productRatings, int ratingThreshold){
//TODO
}
```

## Constraints

1 <= n <= 200

0 <= starReviews < totalReviews <= 100

1 <= ratingsThreshold < 100

productRatings contains only non negative integers

## Ranking
Gold Rank: 30min

Silver Rank: 45min

Bronze Rank: 90min

## Follow-Up
Summarize your approach for solving this problem
Can you estimate the complexity of your solution
Having more time, how would you improve this code

## Solutions
2020-12-21 - https://gist.github.com/mreaugusto/6d523ef731f1120a0b4105bce495c1d1
