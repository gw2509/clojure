(ns difference-of-squares2)

;; Naive O(N) solution which iterates through N numbers

(defn square-of-sum
  "Returns the square of the sum of the numbers up to N."
  [N]
  (let [sum (reduce + (range 1 (inc N)))]
    (* sum sum)))

(defn sum-of-squares
  "Returns the sum of the squares of the numbers up to N."
  [N]
  (reduce (fn [acc n] (+ acc (* n n))) 0 (range 1 (inc N))))

(defn difference
  "Returns the difference between the square of the sum
  and the sum of the squares of the numbers up to N."
  [N]
  (- (square-of-sum N) (sum-of-squares N)))

;; --

(defn square-of-sum
  [N]
  (let [sum (* N (inc N) 0.5)]
    (int (* sum sum))))

(defn sum-of-squares
  [N]
  (/ (* N (inc N) (+ (* 2 N) 1)) 6))

(defn difference
  "Returns the difference between the square of the sum
  and the sum of the squares of the numbers up to N."
  [N]
  (- (square-of-sum N) (sum-of-squares N)))
