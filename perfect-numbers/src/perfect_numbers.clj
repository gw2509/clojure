(ns perfect-numbers)

(defn factors-of [x]
  (if (<= x 1)
    []
    (loop [n 1
           factors []]
      (cond
        (> n (int (Math/sqrt x))) factors
        (zero? (rem x n)) (let [complement (/ x n)]
                            (if (= n complement)
                              (recur (inc n) (conj factors n))
                              (if (= complement x)
                                (recur (inc n) (conj factors n))
                                (recur (inc n) (conj factors n complement)))))
        :else (recur (inc n) factors)))))

(defn classify
  "Classifies the given number as perfect, abundant, or deficient."
  [num]
  (let [aliquot-sum (reduce + (factors-of num))]
    (cond
      (== num aliquot-sum) :perfect
      (< num aliquot-sum) :abundant
      :else :deficient)))

