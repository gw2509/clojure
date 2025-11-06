(ns space-age)


(def seconds_in_a_year (* 86400 365.25))


(defn on-mercury
  "Returns someone's age on Mercury based on the given age in seconds"
  [seconds]
  (/ seconds (* 0.2408467 seconds_in_a_year)))


(defn on-venus
  "Returns someone's age on Venus based on the given age in seconds"
  [seconds]
  (/ (/ seconds seconds_in_a_year) 0.61519726))


(defn on-earth
  "Returns someone's age on Earth based on the given age in seconds"
  [seconds]
  (/ seconds seconds_in_a_year))


(defn on-mars
  "Returns someone's age on Mars based on the given age in seconds"
  [seconds]
  (/ seconds (* 1.8808158 seconds_in_a_year)))


(defn on-jupiter
  "Returns someone's age on Jupiter based on the given age in seconds"
  [seconds]
  (/ seconds (* 11.862615 seconds_in_a_year)))


(defn on-saturn
  "Returns someone's age on Saturn based on the given age in seconds"
  [seconds]
  (/ seconds (* 29.447498 seconds_in_a_year)))


(defn on-uranus
  "Returns someone's age on Uranus based on the given age in seconds"
  [seconds]
  (/ seconds (* 84.016846 seconds_in_a_year)))


(defn on-neptune
  "Returns someone's age on Neptune based on the given age in seconds"
  [seconds]
  (/ seconds (* 164.79132 seconds_in_a_year)))
