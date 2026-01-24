object UniqueMergeSort {

  def sortUnique(v: Vector[Int]): Vector[Int] =
    if (v.size < 2) v
    else {
      val (l, r) = v.splitAt(v.size / 2)
      merge(sortUnique(l), sortUnique(r))
    }

  private def merge(a: Vector[Int], b: Vector[Int]): Vector[Int] =
    (a, b) match {
      case (ah +: at, bh +: bt) =>
        if (ah < bh) ah +: merge(at, b).filter(_ != ah)
        else if (ah > bh) bh +: merge(a, bt).filter(_ != bh)
        else ah +: merge(at, bt).filter(_ != ah)
      case _ => a ++ b
    }
}