package algorithms.search;

public class DeformationBSearch {
    public static void main(String[] args) {
        int[] data = {1,3,6,8,9,9,9,9,17,17,25,4378};
        int key = 0;
        System.out.println(search(data, 0, data.length-1, key));
        //System.out.println(searchFirst_recurs(data, 0, data.length-1, key));
        //System.out.println(searchFirst(data, key));
        //System.out.println(searchLast_recurs(data, 0, data.length-1, key));
        //System.out.println(searchLast(data, key));
        System.out.println(searchFirstGreaterOrEqual_recurs(data, 0, data.length-1, key));
        System.out.println(searchFirstGreaterOrEqual(data, key));
        //System.out.println(searchLastLessOrEqual_recurs(data, 0, data.length-1, key));
        //System.out.println(searchLastLessOrEqual(data, key));

    }

    /**
     * 查找第一个等于给定值的元素
     */
    public static int search(int[] data, int left, int right, int key) {
        int mid = left + ((right - left) >>> 1);
        if (left > right) return -1;
        if (data[mid] == key) {
            return mid;
        } else if (data[mid] < key) {
            return search(data, mid + 1, right, key);
        } else {
            return search(data, left, mid - 1, key);
        }
    }

    /**
     * 递归
     * 查找第一个等于给定值的元素
     */
    public static int searchFirst_recurs(int[] data, int left, int right, int key) {
        int mid = left + ((right - left) >>> 1);
        if (left > right) return -1;
        if (data[mid] == key) {
            if (mid == 0 || data[mid-1] < key) {
                return mid;
            } else {
                return searchFirst_recurs(data, left, mid-1, key);
            }
        } else if (data[mid] < key) {
            return searchFirst_recurs(data, mid + 1, right, key);
        } else {
            return searchFirst_recurs(data, left, mid - 1, key);
        }
    }

    /**
     * 非递归
     * 查找第一个等于给定值的元素
     */
    public static int searchFirst(int[] data, int key) {
        int left = 0;
        int right = data.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            if (data[mid] == key) {
                if (mid == 0 || data[mid-1] < key) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else if (data[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个值等于给定值的元素
     * @param key
     */
    public static int searchLast_recurs(int[] data, int left, int right, int key) {
        int mid = left + ((right - left) >>> 1);
        if (left > right) return -1;
        if (data[mid] == key) {
            if (mid == data.length-1 || data[mid+1] > key) {
                return mid;
            } else {
                return searchLast_recurs(data, mid+1, right, key);
            }
        } else if (data[mid] < key) {
            return searchLast_recurs(data, mid+1, right, key);
        } else {
            return searchLast_recurs(data, left, mid-1, key);
        }
    }

    /**
     * 查找最后一个值等于给定值的元素
     * @param key
     */
    public static int searchLast(int[] data, int key) {
        int left = 0;
        int right = data.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            if (data[mid] == key) {
                if (mid == data.length - 1 || data[mid+1] > key) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            } else if (data[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素
     * @param key
     * @return
     */
    public static int searchFirstGreaterOrEqual(int[] data, int key) {
        int left = 0;
        int right = data.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
                if (data[mid] >= key) {
                    if (mid == 0 || data[mid-1] < key) {
                        return mid;
                    } else {
                        right = mid - 1;
                    }
                }  else {
                    left = mid + 1;
                }

            }
        return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素
     * @param key
     * @return
     */
    public static int searchFirstGreaterOrEqual_recurs(int[] data, int left, int right, int key) {
        int mid = left + ((right - left) >>> 1);
        if (left > right) return -1;
        if (data[mid] >= key) {
            if (mid == 0 || data[mid-1] < key) {
                return mid;
            } else {
                return searchFirstGreaterOrEqual_recurs(data, left, mid-1, key);
            }
        }  else {
            return searchFirstGreaterOrEqual_recurs(data, mid+1, right, key);
        }
    }

    /**
     * 查找最后一个小于等于给定值的元素(递归)
     * @param key
     * @return
     */
    public static int searchLastLessOrEqual(int[] data, int key) {
        int left = 0;
        int right = data.length - 1;
        while (left <= right) {
           int mid = left + ((right - left) >>> 1);
           if (data[mid] <= key) {
               if (mid == data.length - 1 || data[mid+1] > key) {
                   return mid;
               } else {
                   left = mid + 1;
               }
           }  else {
               right = mid - 1;
           }
       }
       return -1;
    }

    /**
     * 查找最后一个小于等于给定值的元素(递归)
     * @param key
     * @return
     */
    public static int searchLastLessOrEqual_recurs(int[] data, int left, int right, int key) {
        if (left > right) return -1;
        int mid = left + ((right - left) >>> 1);
        if (data[mid] <= key) {
            if (mid == data.length-1 || data[mid+1] > key) {
                return mid;
            } else {
                return searchLastLessOrEqual_recurs(data, mid+1, right, key);
            }
        } else {
            return searchLastLessOrEqual_recurs(data, left, mid-1, key);
        }
    }
}
