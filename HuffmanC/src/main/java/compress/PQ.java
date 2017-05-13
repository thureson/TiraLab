package compress;
//package compress;
//
//public class PQ {
//    
//    private static class DefaultComparator implements Comparator {
//        public int compare (Object o1, Object o2) {
//            return ((Comparable) o1).compareTo(o2);
//        }
//    }
//   
//    private Comparator myComp = new DefaultComparator();
//    private int        mySize;
//    private ArrayList  myList;
//
//    /**
//     * This is a trivial iterator class that returns
//     * elements in the PriorityQueue ArrayList field
//     * one-at-a-time
//     */
//    private class PQItr implements Iterator
//    {
//        public Object next()
//        {
//            return myList.get(myCursor);
//        }
//        
//        public boolean hasNext()
//        {
//            return myCursor <= mySize;
//        }
//
//        public void remove()
//        {
//            throw new UnsupportedOperationException("remove not implemented");
//        }
//        
//        private int myCursor = 1;
//    }
//
//    
//    
//    /**
//     * constructs an empty priority queue, when new elements
//     * are added their natural order will be used to determine
//     * which is minimal. This means elements that are added must
//     * implement the <code>Comparable</code> interface and must
//     * be <em>mutually comparable</em>, i.e.,
//     * <code>e1.compareTo(e2)</code> must not throw a
//     * <code>CastCastException</code> for any two elements <code>e1</code>
//     * and <code>e2</code> in the priority queue.
//     */
//    
//    public PriorityQueue()
//    {
//        myList = new ArrayList(32);
//        myList.add(null);             // first slot has index 1
//        mySize = 0;
//    }
//
//    /**
//     * constructs an empty priority queue, when new elements
//     * are added the <code>Comparator comp</code> determines which is
//     * smaller.
//     *
//     * @param comp is the <code>Comparator</code> used in determining order
//     */
//
//    public PriorityQueue(Comparator comp)
//    {
//        this();
//        myComp = comp;
//    }
//
//    /**
//     * all elements in coll are added to the priority queue. The
//     * complexity is O(n) where <code>coll.size() == n</code>
//     *
//     * @param coll is a collection of mutually comparable elements
//     */
//
//    public PriorityQueue(Collection coll)
//    {
//        this();
//        myList.addAll(coll);
//        mySize = coll.size();
//
//        for(int k=coll.size()/2; k >= 1; k--)
//        {
//            heapify(k);
//        }
//    }
//
//    /**
//     * A new element <code>o</code> is added to the priority queue
//     * in O(log n) time where n is the size of the priority queue.
//     * <P>
//     * The return value should be ignored, a boolean value must be
//     * returned because of the requirements of the
//     * <code>Collection</code> interface.
//     *
//     * @param o is the (Comparable) object added to the priority queue
//     * @return true
//     */
//    
//    public boolean add(Object o)
//    {
//        myList.add(o);        // stored, but not correct location
//        mySize++;             // added element, update count
//        int k = mySize;       // location of new element
//
//        while (k > 1 && myComp.compare(myList.get(k/2), o) > 0)
//        {
//            myList.set(k, myList.get(k/2));
//            k /= 2;
//        }
//        myList.set(k,o);
//        
//        return true;
//    }
//
//    /**
//     * @return the number of elements in the priority queue
//     */
//    public int size()
//    {
//        return mySize;
//    }
//
//    /**
//     * @return true if and only if the priority queue is empty
//     */
//    public boolean isEmpty()
//    {
//        return mySize == 0;
//    }
//
//    /**
//     * The smallest/minimal element is removed and returned
//     * in O(log n) time where n is the size of the priority queue.
//     *
//     * @return the smallest element (and removes it)
//     */
//    
//    public Object remove()
//    {
//        if (! isEmpty())
//        {
//            Object hold = myList.get(1);
//            
//            myList.set(1, myList.get(mySize));  // move last to top
//            myList.remove(mySize);              // pop last off
//            mySize--;
//            if (mySize > 1)
//            {
//                heapify(1);
//            }
//            return hold;
//        }
//        return null;
//    }
//
//    /**
//     * Executes in O(1) time, returns smallest element
//     * @return the minimal element in the priority queue
//     */
//    
//    public Object peek()
//    {
//        return myList.get(1);
//    }
//
//    /**
//     * The order of the elements returned by the iterator is not specified
//     * @return an iterator of all elements in priority queue
//     */
//    
//    public Iterator iterator()
//    {
//        return new PQItr();
//    }
//
//    /**
//     * works in O(log(size()-vroot)) time
//     * @param vroot is the index at which re-heaping occurs
//     * @precondition: subheaps of index vroot are heaps
//     * @postcondition: heap rooted at index vroot is a heap
//     */
//    
//    private void heapify(int vroot)
//    {
//        Object last = myList.get(vroot);
//        int child, k = vroot;
//        while (2*k <= mySize)
//        {
//            child = 2*k;
//            if (child < mySize &&
//                        myComp.compare(myList.get(child),
//                                       myList.get(child+1)) > 0)
//            {
//                child++;
//            }
//            if (myComp.compare(last, myList.get(child)) <= 0)
//            {
//                break;
//            }
//            else
//            {
//                myList.set(k, myList.get(child));
//                k = child;
//            }
//        }
//        myList.set(k, last);
//    }