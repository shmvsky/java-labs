# Collections Framework

The Java platform includes a collections framework. A collection is an object that represents a group of objects (such as the classic Vector class). 
A collections framework is a unified architecture for representing and manipulating collections, 
enabling collections to be manipulated independently of implementation details.
The primary advantages of a collections framework are that it:
- Reduces programming effort by providing data structures and algorithms so you don't have to write them yourself
- Increases performance by providing high-performance implementations of data structures and algorithms. 
  Because the various implementations of each interface are interchangeable, programs can be tuned by switching implementations
- Provides interoperability between unrelated APIs by establishing a common language to pass collections back and forth
- Reduces the effort required to learn APIs by requiring you to learn multiple ad hoc collection APIs
- Reduces the effort required to design and implement APIs by not requiring you to produce ad hoc collections APIs
- Fosters software reuse by providing a standard interface for collections and algorithms with which to manipulate them

Many of the modification methods in the collection interfaces are labeled optional. 
Implementations are permitted to not perform one or more of these operations, 
throwing a runtime exception (UnsupportedOperationException) if they are attempted. 
The documentation for each implementation must specify which optional operations are supported. 
Several terms are introduced to aid in this specification:
- Collections that do not support modification operations (such as add, remove and clear) are referred to as unmodifiable. 
Collections that are not unmodifiable are modifiable.
- Collections that additionally guarantee that no change in the Collection object will be visible are referred to as immutable.
Collections that are not immutable are mutable.
- Lists that guarantee that their size remains constant even though the elements can change are referred to as fixed-size. 
Lists that are not fixed-size are referred to as variable-size.
- Lists that support fast (generally constant time) indexed element access are known as random access lists. 
Lists that do not support fast indexed element access are known as sequential access lists. The RandomAccess marker interface enables lists to advertise the fact that they support random access. This enables generic algorithms to change their behavior to provide good performance when applied to either random or sequential access lists.

## Интерфейсы
The collection interfaces are divided into two groups. 
The most basic interface, java.util.Collection, has the following descendants:
- java.util.Set
- java.util.SortedSet
- java.util.NavigableSet
- java.util.Queue
- java.util.concurrent.BlockingQueue
- java.util.concurrent.TransferQueue
- java.util.Deque
- java.util.concurrent.BlockingDeque

The other collection interfaces are based on java.util.Map and are not true collections. 
However, these interfaces contain collection-view operations, which enable them to be manipulated as collections. 
Map has the following offspring:
- java.util.SortedMap
- java.util.NavigableMap
- java.util.concurrent.ConcurrentMap
- java.util.concurrent.ConcurrentNavigableMap


## Design Goals
The main design goal was to produce an API that was small in size and, more importantly, in "conceptual weight." 
It was critical that the new functionality not seem too different to current Java programmers; 
it had to augment current facilities, rather than replace them. 
At the same time, the new API had to be powerful enough to provide all the advantages described previously.

To keep the number of core interfaces small, the interfaces do not attempt to capture such subtle distinctions as mutability, modifiability, and resizability. 
Instead, certain calls in the core interfaces are optional, enabling implementations to throw an UnsupportedOperationException to indicate that they do not support a specified optional operation. 
Collection implementers must clearly document which optional operations are supported by an implementation.

To keep the number of methods in each core interface small, an interface contains a method only if either:
- It is a truly fundamental operation: a basic operations in terms of which others could be reasonably defined,
- There is a compelling performance reason why an important implementation would want to override it.

It was critical that all reasonable representations of collections interoperate well. 
This included arrays, which cannot be made to implement the Collection interface directly without changing the language.
Thus, the framework includes methods to enable collections to be moved into arrays, arrays to be viewed as collections, and maps to be viewed as collections.





The root interface in the collection hierarchy. A collection represents a group of objects, known as its elements. Some collections allow duplicate elements and others do not. Some are ordered and others unordered. The JDK does not provide any direct implementations of this interface: it provides implementations of more specific subinterfaces like Set and List. This interface is typically used to pass collections around and manipulate them where maximum generality is desired.
Bags or multisets (unordered collections that may contain duplicate elements) should implement this interface directly.
All general-purpose Collection implementation classes (which typically implement Collection indirectly through one of its subinterfaces) should provide two "standard" constructors: a void (no arguments) constructor, which creates an empty collection, and a constructor with a single argument of type Collection, which creates a new collection with the same elements as its argument. In effect, the latter constructor allows the user to copy any collection, producing an equivalent collection of the desired implementation type. There is no way to enforce this convention (as interfaces cannot contain constructors) but all of the general-purpose Collection implementations in the Java platform libraries comply.
Certain methods are specified to be optional. If a collection implementation doesn't implement a particular operation, it should define the corresponding method to throw UnsupportedOperationException. Such methods are marked "optional operation" in method specifications of the collections interfaces.

Some collection implementations have restrictions on the elements that they may contain. For example, some implementations prohibit null elements, and some have restrictions on the types of their elements. Attempting to add an ineligible element throws an unchecked exception, typically NullPointerException or ClassCastException. Attempting to query the presence of an ineligible element may throw an exception, or it may simply return false; some implementations will exhibit the former behavior and some will exhibit the latter. More generally, attempting an operation on an ineligible element whose completion would not result in the insertion of an ineligible element into the collection may throw an exception or it may succeed, at the option of the implementation. Such exceptions are marked as "optional" in the specification for this interface.
It is up to each collection to determine its own synchronization policy. In the absence of a stronger guarantee by the implementation, undefined behavior may result from the invocation of any method on a collection that is being mutated by another thread; this includes direct invocations, passing the collection to a method that might perform invocations, and using an existing iterator to examine the collection.


