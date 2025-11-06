(ns coordinate-transformation)

(defn translate2d 
  "Returns a function making use of a closure to
   perform a repeatable 2d translation of a coordinate pair."
  [dx dy]
  (fn [x y] [(+ x dx) (+ y dy)]))


(defn scale2d 
  "Returns a function making use of a closure to
   perform a repeatable 2d scale of a coordinate pair."
  [sx sy]
  (fn [x y] [(* x sx) (* y sy)]))


(defn compose-transform
  "Create a composition function that returns a function that 
   combines two functions to perform a repeatable transformation."
  [f g]
  ;; Applies function f to x,y then passes the result as arguments to function g
  (fn [x y] (apply g (f x y))))


(defn memoize-transform
  "Returns a function that memoizes the last result.
   If the arguments are the same as the last call,
   the memoized result is returned."
  [f]
  ;; Create an atom to store the last input arguments and result
  (let [mem (atom {:last-x      nil
                   :last-y      nil
                   :last-result nil})]
    (fn [& args]
      ;; Check if current arguments match the memoized values
      (if-let [vals (and (= args [(:last-x @mem) (:last-y @mem)])
                         (:last-result @mem))]
        vals
        ;; Calculate new result and update memoized values
        (let [result (apply f args)]
          (swap! mem assoc :last-x (first args))
          (swap! mem assoc :last-y (last args))
          (swap! mem assoc :last-result result)
          result)))))


