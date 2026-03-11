(ns binary-search)


(defn search-for
  "Returns the index of num in coll, or -1 if num is not found."
  [num coll]
  (loop [l 0
         h (dec (count coll))]
    (if (> l h)
      -1
      (let [m (+ l (quot (- h l) 2))
            v (nth   coll m)]
        (cond
          (= v num) m
          (> v num) (recur l (dec m))
          :else (recur (inc m) h))))))


