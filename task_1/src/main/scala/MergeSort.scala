object MergeSort {
  def sort(v: Vector[Int]): Vector[Int] =
    if (v.size < 2) v else {
      val (l, r) = v.splitAt(v.size / 2)
      merge(sort(l), sort(r))
    }

  private def merge(a: Vector[Int], b: Vector[Int]): Vector[Int] =
    (a, b) match {
      case (ah +: at, bh +: bt) =>
        if (ah < bh) ah +: merge(at, b)
        else bh +: merge(a, bt)
      case _ => a ++ b
    }
}