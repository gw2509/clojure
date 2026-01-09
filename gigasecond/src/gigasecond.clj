(ns gigasecond)

(def gigasecond 1000000000)

(defn from
  "Determines the date one gigasecond after the given date."
  [year month day]
  (let [base-date (java.time.LocalDateTime/of year month day 0 0)
        fd (.plusSeconds base-date gigasecond)]
    [(.getYear fd)
     (.getMonthValue fd)
     (.getDayOfWeek fd)]))