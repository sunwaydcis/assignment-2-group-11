trait HospData {
  def date: String
  def state: String
  def beds: Int
  def beds_covid: Int
  def beds_noncrit: Int
  def admitted_pui: Int
  def admitted_covid: Int
  def admitted_total: Int
  def discharged_pui: Int
  def discharged_covid: Int
  def discharged_total: Int
  def hosp_covid: Int
  def hosp_pui: Int
  def hosp_noncovid: Int
}

case class HospRecord(
  date: String,
  state: String,
  beds: Int,
  beds_covid: Int,
  beds_noncrit: Int,
  admitted_pui: Int,
  admitted_covid: Int,
  admitted_total: Int,
  discharged_pui: Int,
  discharged_covid: Int,
  discharged_total: Int,
  hosp_covid: Int,
  hosp_pui: Int,
  hosp_noncovid: Int
) extends HospData

  
