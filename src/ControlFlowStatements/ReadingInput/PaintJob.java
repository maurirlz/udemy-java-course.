package ControlFlowStatements.ReadingInput;

public class PaintJob {

    public static void main(String[] args) {

        System.out.println(getBucketCount((7.25 * 4.3),2.35));
        System.out.println(getBucketCount(7.25,4.3,2.35));
        System.out.println(getBucketCount(7.25,4.3,2.35,4));

    }

    public static int getBucketCount(double width, double height, double areaPerBucket, int extraBuckets) {

        if ((extraBuckets < 0) || (width <= 0) || (height <= 0) || (areaPerBucket <= 0)) {

            return -1;
        }

        return getBucketCount(width, height, areaPerBucket) - extraBuckets;
    }

    public static int getBucketCount(double width, double height, double areaPerBucket) {

        if ((width <= 0) || (height <= 0)) {

            return -1;
        }

        return getBucketCount((width * height), areaPerBucket);
    }

    public static int getBucketCount(double area, double areaPerBucket) {

        if ((area <= 0) || (areaPerBucket <= 0)) {

            return -1;
        }

        return (int) Math.ceil(area / areaPerBucket);
    }
}
