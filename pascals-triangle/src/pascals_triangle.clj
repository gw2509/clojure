(ns pascals-triangle)

(defn row [previous]
  (vec (map + (cons 0 previous) (conj previous 0))))


(defn row [previous]
  (mapv + (cons 0 previous) (conj previous 0)))


(def triangle
  (iterate row [1]))