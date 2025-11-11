(ns sum-of-multiples)


(defn sum-of-multiples
  "Calculates the sum of multiples of the given numbers
  that are less than the limit."
  [numbers limit]
  (apply + (distinct (mapcat #(range % limit %) numbers))))


(defn sum-of-multiples
  [numbers limit]
  (->> numbers
       (mapcat #(range % limit %))
       set
       (apply +)))