(ns saddle-points)

(defn good-tree?
  [row-maxes col-mins x y v]
  (when (and (= v (row-maxes y))
             (= v (col-mins x)))
    [(inc y) (inc x)]))

(defn saddle-points
  "Returns the saddle points of a matrix."
  [matrix]
  (if (empty? matrix)
    #{}
    (let [row-maxes (mapv #(apply max %) matrix)
          col-mins (mapv #(apply min %) (apply map vector matrix))]
      (->> matrix
           (map-indexed (fn [y row]
                          (map-indexed (fn [x v]
                                         (good-tree? row-maxes col-mins x y v))
                                       row)))
           (apply concat)
           (remove nil?)
           set))))

;; or..

(defn saddle-points
  "Returns the saddle points of a matrix"
  [matrix]
  (let [cols (apply map vector matrix)
        max-row (for [row matrix] (apply max row))
        min-col (for [col cols] (apply min col))]
    (into #{}
          (for [[i row] (map-indexed vector max-row)
                [j col] (map-indexed vector min-col)
                :when (>= col row)]
            [(inc i) (inc j)]))))