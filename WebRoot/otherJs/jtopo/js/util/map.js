/*
 * MAP对象，实现MAP功能 接口： size() 获取MAP元素个数 isEmpty() 判断MAP是否为空 clear() 删除MAP所有元素
 * put(key, value) 向MAP中增加元素（key, value) removeByValueAndKey (key)
 * 删除指定KEY的元素，成功返回True，失败返回False get(key) 获取指定KEY的元素值VALUE，失败返回NULL
 * element(index) 获取指定索引的元素（使用element.key，element.value获取KEY和VALUE），失败返回NULL
 * containsKey(key) 判断MAP中是否含有指定KEY的元素 containsValue(value) 判断MAP中是否含有指定VALUE的元素
 * values() 获取MAP中所有VALUE的数组（ARRAY） keys() 获取MAP中所有KEY的数组（ARRAY）
 * 
 * 例子： var map = new Map(); map.put("key", "value"); var val = map.get("key")
 */
function Map() {
	this.elements = new Array, this.size = function() {
		return this.elements.length
	}, this.isEmpty = function() {
		return this.elements.length < 1
	}, this.clear = function() {
		this.elements = new Array
	}, this.put = function(a, b) {
		this.elements.push({
			key : a,
			value : b
		})
	}, this.removeByKey = function(a) {
		var b = !1;
		try {
			for (i = 0; i < this.elements.length; i++)
				if (this.elements[i].key == a)
					return this.elements.splice(i, 1), !0
		} catch (c) {
			b = !1
		}
		return b
	}, this.removeByValue = function(a) {
		var b = !1;
		try {
			for (i = 0; i < this.elements.length; i++)
				if (this.elements[i].value == a)
					return this.elements.splice(i, 1), !0
		} catch (c) {
			b = !1
		}
		return b
	}, this.removeByValueAndKey = function(a, b) {
		var c = !1;
		try {
			for (i = 0; i < this.elements.length; i++)
				if (this.elements[i].value == b && this.elements[i].key == a)
					return this.elements.splice(i, 1), !0
		} catch (d) {
			c = !1
		}
		return c
	}, this.get = function(a) {
		try {
			for (i = 0; i < this.elements.length; i++)
				if (this.elements[i].key == a)
					return this.elements[i].value
		} catch (b) {
			return !1
		}
		return !1
	}, this.element = function(a) {
		return 0 > a || a >= this.elements.length ? null : this.elements[a]
	}, this.containsKey = function(a) {
		var b = !1;
		try {
			for (i = 0; i < this.elements.length; i++)
				this.elements[i].key == a && (b = !0)
		} catch (c) {
			b = !1
		}
		return b
	}, this.containsValue = function(a) {
		var b = !1;
		try {
			for (i = 0; i < this.elements.length; i++)
				this.elements[i].value == a && (b = !0)
		} catch (c) {
			b = !1
		}
		return b
	}, this.containsObj = function(a, b) {
		var c = !1;
		try {
			for (i = 0; i < this.elements.length; i++)
				this.elements[i].value == b && this.elements[i].key == a
						&& (c = !0)
		} catch (d) {
			c = !1
		}
		return c
	}, this.values = function() {
		var a = new Array;
		for (i = 0; i < this.elements.length; i++)
			a.push(this.elements[i].value);
		return a
	}, this.valuesByKey = function(a) {
		var b = new Array;
		for (i = 0; i < this.elements.length; i++)
			this.elements[i].key == a && b.push(this.elements[i].value);
		return b
	}, this.keys = function() {
		var a = new Array;
		for (i = 0; i < this.elements.length; i++)
			a.push(this.elements[i].key);
		return a
	}, this.keysByValue = function(a) {
		var b = new Array;
		for (i = 0; i < this.elements.length; i++)
			a == this.elements[i].value && b.push(this.elements[i].key);
		return b
	}, this.keysRemoveDuplicate = function() {
		var b, c, a = new Array;
		for (i = 0; i < this.elements.length; i++) {
			for (b = !0, c = 0; c < a.length; c++)
				if (a[c] == this.elements[i].key) {
					b = !1;
					break
				}
			b && a.push(this.elements[i].key)
		}
		return a
	}
}
