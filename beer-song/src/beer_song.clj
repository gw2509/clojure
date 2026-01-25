(ns beer-song
  (:require [clojure.string :as str]))

(defn humanise
  [n s]
  (if (= n 1)
    s
    (str s "s")))

(defn sub-parts
  [num]
  (let [rem (dec num)]
    (-> {}
        (assoc :rem rem)
        (assoc :rem-text (if (> num 1) (str rem) "no more"))
        (assoc :article (if (> num 1) "one" "it")))))

(defn verse
  "Returns the nth verse of the song."
  [num]
  (let [{:keys [rem rem-text article]} (sub-parts num)]
    (if (pos? num)
      (str num " " (humanise num "bottle")
           " of beer on the wall, "
           num " " (humanise num "bottle") " of beer.\nTake " article " down and pass it around, "
           rem-text " " (humanise rem "bottle") " of beer on the wall.\n")
      (str "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n"))))

(defn sing
  "Given a start and an optional end, returns all verses in this interval. If
  end is not given, the whole song from start is sung."
  ([start]
   (sing start 0))
  ([start end]
   (str/join "\n" (map verse (range start (dec end) -1)))))
