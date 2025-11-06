(ns grains)


(defn square
  "Returns the number of grains on the n-th chessboard square."
  [n]
  (.pow (BigInteger. "2") (dec n)))

(defn square
  [n]
  (apply *' (repeat (dec n) 2)))                            ;; 2^5 => (apply *' (2 2 2 2)) = 16


(defn total
  "Returns the total number of grains on the chessboard."
  []
  (reduce + (map square (range 1 (+ 64 1)))))

(defn total
  []
  (dec (square 65)))
