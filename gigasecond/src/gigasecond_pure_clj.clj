(ns gigasecond-pure-clj
  (:require [java-time.api :as jt]))

(def gigasecond 1000000000)

(defn from
  "Determines the date one gigasecond after the given date."
  [year month day]
  (let [base-date (jt/local-date-time year month day)
        fd (jt/plus base-date (jt/seconds gigasecond))]
    [(jt/as fd :year)
     (jt/as fd :month-of-year)
     (jt/as fd :day-of-month)]))