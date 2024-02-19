async function test_item(){ 
    const url = "http://localhost:8080/store";

    try{
        console.log("fetching");
        const res = await fetch(url);
        if (res.status === 200){
            const data = await res.json();
            for (product of data){
                single_display(product);
            }
        }
        else{
            console.log("fail");
        }
    }  
    catch (err){
        console.log(err);
    }
}

async function single_display(product){
    const shop = document.getElementById("shop-display");
    const item = document.createElement("div");
    item.setAttribute("class", "item");

    const item_name = document.createElement("p");
    item_name.innerHTML = product.name;
    item.appendChild(item_name);

    const item_img_url = product.image_path;
    const item_img = document.createElement("img");
    item_img.setAttribute("src", item_img_url);
    item_img.setAttribute("alt", "Failed to load "+item_name);
    item.appendChild(item_img);
            
    const item_price = document.createElement("p");
    item_price.innerHTML = product.price;
    item.appendChild(item_price);

    const item_desc = document.createElement("p");
    item_desc.innerHTML = product.description;
    item.appendChild(item_desc);
            
    shop.appendChild(item);
}