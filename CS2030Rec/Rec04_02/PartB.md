Recap: When we declare a list and print the list as follows,
List<Point> list = new ArrayList<>();
list.add(new Point(1.0, 1.0));
list.add(new Point(2.0, 2.0));
System.out.println(list);   // How does this work?

List has access to iterator() which returns an Iterator<E> instance.
This Iterator<E> uses E next() [return next item] and boolean hasNext() [check if any item remaining] to run commands on each item until no items are left.

Iterator<Point> iter = list.iterator();
while (iter.hasNext()) {
System.out.println(iter.next());
}


Question: How is the use of an iterator different from the following:
for (Point p : list) {
System.out.println(p);
}

Both methods give the same exact result of printing items in the list one by one.
However, my guess is that the iterator takes shorter time and memory, because the iterator just checks for two functions hasNext and next in each loop
Whereas the other method checks for p, list and p again in each iteration.


Answer: WRONG.
From the Iterator class, there is a remove() method that removes the last element
returned by the iterator.

ie if we run:
Iterator<Point> iter = list.iterator();
while (iter.hasNext()) {
System.out.println(iter.next());
iter.remove();
}

After printing all the items, the list returned will become empty. This is an additional built-in functionality of an Iterator.

