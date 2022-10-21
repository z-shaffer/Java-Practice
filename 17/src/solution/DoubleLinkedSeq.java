package solution;

import util.DoubleNode;
/**
 * A DoubleLinkedSeq is a sequence of double numbers. The sequence can have a
 * special &quot;current element&quot;, which is specified and accessed through
 * four methods that are not available in the IntArrayBag class (start,
 * getCurrent, advance, and isCurrent).
 * 
 * Limitations:
 * 
 * Beyond Integer.MAX_VALUE element, the size method does not work.
 * 
 * @author ???
 * @version ???
 */
public class DoubleLinkedSeq implements Cloneable
{

    private DoubleNode head;
    private DoubleNode tail;
    private DoubleNode cursor;
    private DoubleNode precursor;
    private int manyNodes;

    /**
     * Initializes an empty DoubleLinkedSeq.
     * 
     * @postcondition This sequence is empty.
     */
    public DoubleLinkedSeq()
    {
        head = null;
        tail = null;
        cursor = null;
        precursor = null;
        manyNodes = 0;
    }

    /**
     // code for constructor
     // * Adds a new element to this sequence.
     * 
     * @param element
     *            the new element that is being added to this sequence.
     * 
     * @postcondition a new copy of the element has been added to this sequence.
     *                If there was a current element, then this method places
     *                the new element before the current element. If there was
     *                no current element, then this method places the new
     *                element at the front of this sequence. The newly added
     *                element becomes the new current element of this sequence.
     */
    public void addBefore(double element)
    {
        if (manyNodes == 0)
        {
            head = new DoubleNode(element);
            tail = head;
            cursor = head;
        }
        else if (!isCurrent() || cursor == head)
        {
            head = new DoubleNode(element, head);
            cursor = head;
            precursor = null;
        }
        else
        {
            precursor.addNodeAfter(element);
            cursor = precursor.getLink();
        }
        manyNodes++;
    }

    /**
     * Adds a new element to this sequence.
     * 
     * @param element
     *            the new element that is being added to this sequence.
     * 
     * @postcondition a new copy of the element has been added to this sequence.
     *                If there was a current element, then this method places
     *                the new element after the current element. If there was no
     *                current element, then this method places the new element
     *                at the end of this sequence. The newly added element
     *                becomes the new current element of this sequence.
     */
    public void addAfter(double element)
    {

        if (manyNodes == 0)
        {
            tail = new DoubleNode(element);
            head = tail;
            cursor = tail;
        }
        else if (!isCurrent() || cursor == tail)
        {
            tail.addNodeAfter(element);
            precursor = tail;
            tail = tail.getLink();
            cursor = tail;
        }
        else
        {
            cursor.addNodeAfter(element);
            precursor = cursor;
            cursor = cursor.getLink();
        }
        manyNodes++;
    }

    /**
     * Places the contents of another sequence at the end of this sequence.
     * 
     * @precondition other must not be null.
     * 
     * @param other
     *            a sequence show contents will be placed at the end of this
     *            sequence.
     * 
     * @postcondition the elements from other have been placed at the end of
     *                this sequence. The current element of this sequence
     *                remains where it was, and other is unchanged.
     * 
     * @throws NullPointerException
     *             if other is null.
     */
    public void addAll(DoubleLinkedSeq other) throws NullPointerException
    {
        DoubleNode[ ] copyInfo;
        if (other == null)
	{
            throw new NullPointerException("Other is null.");
        }
	if (other.manyNodes > 0)
        {
            copyInfo = DoubleNode.listCopyWithTail(other.head);
            copyInfo[1].setLink(head); 
            head = copyInfo[0]; 
            manyNodes += other.manyNodes;
        }
    }

    /**
     * Move forward so that the current element is now the next element in the
     * sequence.
     * 
     * @precondition isCurrent() returns true.
     * 
     * @postcondition If the current element was already the end element of this
     *                sequence (with nothing after it), then there is no longer
     *                any current element. Otherwise, the new element is the
     *                element immediately after the original current element.
     * 
     * @throws IllegalStateException
     *             if there is not current element.
     */
    public void advance() throws IllegalStateException
    {
        if (isCurrent())
        {
            if (cursor.getLink() == null)
            {
                precursor = null;
                cursor = null;
            }
            else
            {
                precursor = cursor;
                cursor = cursor.getLink();
            }
        }
        else
        {
            throw new IllegalStateException("There is no current element.");
        }
    }

    /**
     * Creates a copy of this sequence.
     * 
     * @return a copy of this sequence. Subsequent changes to the copy will not
     *         affect the original, nor vice versa.
     * @throws RuntimeException
     *             if this class does not implement Cloneable.
     * 
     */
    public DoubleLinkedSeq clone() 
	throws RuntimeException
    {
        DoubleLinkedSeq answer = new DoubleLinkedSeq();
        DoubleNode copyInfo[];
        DoubleNode copyInfo2[];
        try
        {
            if (cursor == null)
            {
                copyInfo = DoubleNode.listCopyWithTail(head);
                answer.head = copyInfo[0];
                answer.tail = copyInfo[1];
                answer.cursor = null;
                answer.precursor = null;
            }
            else if (cursor == head)
            {
                copyInfo = DoubleNode.listCopyWithTail(head);
                answer.head = copyInfo[0];
                answer.tail = copyInfo[1];
                answer.cursor = answer.head;
                answer.precursor = null;
            }
            else
            {
                copyInfo = DoubleNode.listPart(head, precursor);
                copyInfo2 = DoubleNode.listPart(cursor, tail);
                answer.head = copyInfo[0];
                answer.precursor = copyInfo[1];
                answer.cursor = copyInfo2[0];
                answer.tail = copyInfo2[1];
                answer.precursor.setLink(answer.cursor);
            }
        }
        catch (RuntimeException e)
        { 
            throw new RuntimeException("Runtime Exception encountered.");
        }
        answer.manyNodes = manyNodes;
        return answer;
    }

    /**
     * Creates a new sequence that contains all the elements from s1 followed by
     * all of the elements from s2.
     * 
     * @precondition neither s1 nor s2 are null.
     * 
     * @param s1
     *            the first of two sequences.
     * @param s2
     *            the second of two sequences.
     * 
     * @return a new sequence that has the elements of s1 followed by the
     *         elements of s2 (with no current element).
     * 
     * @throws NullPointerException
     *             if s1 or s2 are null.
     */
    public static DoubleLinkedSeq concatenation(DoubleLinkedSeq s1,
            DoubleLinkedSeq s2) throws NullPointerException
    {
        if (s1 == null)
	{
            throw new NullPointerException("b1 is null.");
        }
	if (s2 == null)
	{
            throw new NullPointerException("b2 is null.");
	}
        DoubleLinkedSeq answer = new DoubleLinkedSeq();
        answer.addAll(s1);
        answer.addAll(s2);
        answer.manyNodes = s1.manyNodes + s2.manyNodes;
        return answer;
    }

    /**
     * Returns a copy of the current element in this sequence.
     * 
     * @precondition isCurrent() returns true.
     * 
     * @return the current element of this sequence.
     * 
     * @throws IllegalStateException
     *             if there is no current element.
     */
    public double getCurrent() throws IllegalStateException
    {
        if (isCurrent())
        {
            return cursor.getData();
        }
        else
        {
            throw new IllegalStateException("There is no current element.");
        }
    }

    /**
     * Determines whether this sequence has specified a current element.
     * 
     * @return true if there is a current element, or false otherwise.
     */
    public boolean isCurrent()
    {
        if (cursor == null)
        {
            return false;
        }
        return true;
    }

    /**
     * Removes the current element from this sequence.
     * 
     * @precondition isCurrent() returns true.
     * 
     * @postcondition The current element has been removed from this sequence,
     *                and the following element (if there is one) is now the new
     *                current element. If there was no following element, then
     *                there is now no current element.
     * 
     * @throws IllegalStateException
     *             if there is no current element.
     */
    public void removeCurrent() throws IllegalStateException
    {
        if (isCurrent())
        {
            if (cursor == head)
            {
                head = cursor.getLink();
                cursor = cursor.getLink();
            }
            else if (cursor == tail)
            {
                tail = precursor;
                precursor.setLink(null);
                cursor = null;
                precursor = null;
            }
            else
            {
                precursor.setLink(cursor.getLink());
                cursor = cursor.getLink();
            }
            manyNodes--;
        }
        else
        {
            throw new IllegalStateException("There is no current element.");
        }
    }

    /**
     * Determines the number of elements in this sequence.
     * 
     * @return the number of elements in this sequence.
     */
    public int size()
    {
        // your code goes here
        return manyNodes;
    }

    /**
     * Sets the current element at the front of this sequence.
     * 
     * @postcondition If this sequence is not empty, the front element of this
     *                sequence is now the current element; otherwise, there is
     *                no current element.
     */
    public void start()
    {
        if (manyNodes > 0)
        {
            cursor = head;
            precursor = null;
        }
        else
        {
            cursor = null;
            precursor = null;
        }
    }

    /**
     * Returns a String representation of this sequence. If the sequence is
     * empty, the method should return &quot;&lt;&gt;&quot;. If the sequence has
     * one item, say 1.1, and that item is not the current item, the method
     * should return &quot;&lt;1.1&gt;&quot;. If the sequence has more than one
     * item, they should be separated by commas, for example: &quot;&lt;1.1,
     * 2.2, 3.3&gt;&quot;. If there exists a current item, then that item should
     * be surrounded by square braces. For example, if the second item is the
     * current item, the method should return: &quot;&lt;1.1, [2.2],
     * 3.3&gt;&quot;.
     * 
     * @return a String representation of this sequence.
     */
    @Override
    public String toString()
    {
        String answer = "<";
        if (manyNodes == 0)
        {
            return "<>";
        }
        else
        {
            DoubleNode tempCursor = head;
            while (tempCursor != null)
            {
                if (tempCursor == cursor)
                {
                    answer += "[" + tempCursor.getData() + "]";
                }
                else
                {
                    answer += tempCursor.getData();
                }
                tempCursor = tempCursor.getLink();
                if (tempCursor != null)
                {
                    answer += ", ";
                }
            }
            
        }
        return answer + ">";
    }

    /**
     * Determines if this object is equal to the other object.
     * 
     * @param other
     *            The other object (possibly a DoubleLinkedSequence).
     * @return true if this object is equal to the other object, false
     *         otherwise. Two sequences are equal if they have the same number
     *         of elements, and each corresponding element is equal
     */
    public boolean equals(Object other)
    {
        DoubleLinkedSeq o = (DoubleLinkedSeq) other;
        DoubleNode tempCursor1 = head;
        DoubleNode tempCursor2 = o.head;
        while (tempCursor1 != null && tempCursor2 != null)
        {
            if (tempCursor1.getData() != tempCursor2.getData())
            {
                return false;
            }
            tempCursor1 = tempCursor1.getLink();
            tempCursor2 = tempCursor2.getLink();
        }
        if (manyNodes != o.manyNodes)
        {
            return false;
        }
        if (cursor != o.cursor || precursor != o.precursor)
        {
            return false;
        }
        return true;
    }
}
