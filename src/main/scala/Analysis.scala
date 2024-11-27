class Analysis(val records: Seq[HospData]) {

  // Question 1
  def stateWithMaxBeds: Option[(String, Int)] = {
    records
      .groupBy(_.state)
      .view
      .mapValues(_.map(_.beds).sum)
      .toMap
      .maxByOption(_._2)
  }

  // Question 2
  def covidBedRatio: Double = {
    val totalBeds = records.map(_.beds).sum
    if (totalBeds == 0) 0.0
    else {
      val totalBedsCovid = records.map(_.beds_covid).sum
      totalBedsCovid.toDouble / totalBeds
    }
  }

  // Question 3
  def averageAdmittedByState: Map[String, (Int, Int, Int)] = {
    records.groupBy(_.state).map { case (state, recs) =>
      val totalSuspected = recs.map(_.admitted_pui).sum
      val totalCovid = recs.map(_.admitted_covid).sum
      val totalNonCovid = recs.map(r => math.max(0, r.admitted_pui - r.admitted_covid)).sum
      val count = recs.size
      state -> (
        totalSuspected / count,
        totalCovid / count,
        totalNonCovid / count
      )
    }
  }

  // Question 3
  def safeAverageAdmittedByState: Map[String, (Double, Double, Double)] = {
    records.groupBy(_.state).map { case (state, recs) =>
      val totalSuspected = recs.map(_.admitted_pui).sum.toDouble
      val totalCovid = recs.map(_.admitted_covid).sum.toDouble
      val totalNonCovid = recs.map(r => math.max(0, r.admitted_pui - r.admitted_covid)).sum.toDouble
      val count = recs.size.toDouble
      state -> (
        if (count == 0) (0.0, 0.0, 0.0)
        else (
          totalSuspected / count,
          totalCovid / count,
          totalNonCovid / count
        )
        )
    }
  }
}
 
