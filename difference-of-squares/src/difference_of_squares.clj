(ns difference-of-squares)


(defn square-of-sum
  [N]
  (let [sum (* N (inc N) 1/2)]
    (* sum sum)))


(defn sum-of-squares
  [N]
  (/ (* N (inc N) (+ (* 2 N) 1)) 6))

(defn sum-of-squares [n]                                    ;; transducer
  (transduce (map #(* % %)) + (range (inc n))))


(defn difference
  "Returns the difference between the square of the sum
  and the sum of the squares of the numbers up to N."
  [N]
  (- (square-of-sum N) (sum-of-squares N)))
