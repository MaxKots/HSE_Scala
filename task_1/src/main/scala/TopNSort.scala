import scala.collection.mutable.PriorityQueue

object TopNSort {
  def topN(v: Vector[Int], n: Int): Vector[Int] = {
    if (n <= 0 || v.isEmpty) Vector.empty
    else if (v.size <= n) v.sorted
    else {
      // Правильный синтаксис создания PriorityQueue
      val heap = PriorityQueue[Int]()(Ordering[Int].reverse)

      v.foreach { x =>
        if (heap.size < n) {
          heap.enqueue(x)
        } else if (x < heap.head) {
          heap.dequeue()
          heap.enqueue(x)
        }
      }

      heap.dequeueAll.sorted.toVector
    }
  }
}