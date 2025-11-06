(ns darts)

(defn- distance [x y]
  (Math/sqrt (+ (* x x) (* y y))))


(defn score
  "Calculates the score of a dart throw"
  [x y]
  (let [distance (distance x y)]
    (condp >= distance
      1 10
      5 5
      10 1
      0)))





