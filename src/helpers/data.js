import { fetchBackend } from "./fetch"

export  const handlelist =  async (method='') => {  
    const resp = await fetchBackend(method,{})
    const data = await resp.json();
    return data;
}
