(ns raindrops)

(def divisors {3 "Pling"
               5 "Plang"
               7 "Plong"})

(defn convert
  "Converts a number to its corresponding string of raindrop sounds."
  [num] (let [raindrop (mapcat (fn [[k v]] (when (zero? (rem num k)) v))
                               divisors)]
          (if (not (empty? raindrop)) (apply str raindrop)
                                      (str num))))

(defn convert
  "Converts a number to its corresponding string of raindrop sounds."
  [num] (if-let [raindrop (seq (mapcat (fn [[k v]] (when (zero? (rem num k)) v)) divisors))]
          (apply str raindrop)
          (str num)))
